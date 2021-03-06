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

    def imagewriter(self,radar_id,start_date,end_date):

        try:

            conn = nexradaws.NexradAwsInterface()
            central_timezone = pytz.timezone('US/Central')
            print(radar_id,start_date,end_date,type(radar_id),type(start_date),type(end_date))

            start = central_timezone.localize(start_date)
            end = central_timezone.localize(end_date)
            scans = conn.get_avail_scans_in_range(start, end, radar_id)
            results = conn.download(scans[-1], self.templocation)
            print('uday')
            for result in results.iter_success():
                radar_object=result.open_pyart()
                print('satya')
                display = pyart.graph.RadarDisplay(radar_object)
                plt.switch_backend('Agg')
                display.plot('reflectivity', 0, title="{} {}".format(result.radar_id, result.scan_time))
                display.set_limits((-150, 150), (-150, 150))
            print('krishna')
            plt.savefig('name',format='png')
            path=os.getcwd()+'/'+'name'
            with open(path, 'rb') as output:
                encoded = base64.b64encode(output.read())
                print('ajay')

                json={'image':encoded.decode()}
            output.close()
            return json
        except Exception:
            print('Error while loading the file')
            
        finally:
            dirs = os.listdir()
            cur_dir = os.getcwd()
            for file in dirs:
                file_path = os.path.join(cur_dir, file)
                if file.endswith('.gz'):
                    os.remove(file_path)
                if file.endswith('.png'):
                    os.remove(file_path)











