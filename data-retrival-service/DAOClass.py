import os

import matplotlib.pyplot as plt
import tempfile
import pytz
import base64
import nexradaws
import pyart
class DAOClass:
    def __init__(self):
        self.templocation= tempfile.mkdtemp()

    def imageWriter(self,radar_id,start_date,end_date):

        try:

            conn = nexradaws.NexradAwsInterface()
            central_timezone = pytz.timezone('US/Central')

            start = central_timezone.localize(start_date)
            end = central_timezone.localize(end_date)
            scans = conn.get_avail_scans_in_range(start, end, radar_id)
            results = conn.download(scans[-1], self.templocation)
            for result in results.iter_success():
                radar_object=result.open_pyart()
                display = pyart.graph.RadarDisplay(radar_object)
                plt.switch_backend('Agg')
                display.plot('reflectivity', 0, title="{} {}".format(result.radar_id, result.scan_time))
                display.set_limits((-150, 150), (-150, 150))
            plt.savefig('name',format='png')
            path=os.getcwd()+'/'+'name'
            with open(path, 'rb') as output:
                encoded = base64.b64encode(output.read())

                json={'image':encoded.decode()}
            output.close()
            return json
        except Exception:
            print('Error while loading the file')
            return False
        finally:
            dirs = os.listdir()
            cur_dir = os.getcwd()
            for file in dirs:
                file_path = os.path.join(cur_dir, file)
                if file.endswith('.gz'):
                    os.remove(file_path)
                if file.endswith('.png'):
                    os.remove(file_path)











