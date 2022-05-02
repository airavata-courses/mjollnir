import os
import base64
import pytz
import matplotlib.pyplot as plt
import numpy as np
import tempfile
import nexradaws
import pyart
from datetime import datetime

class metPY:
    def __init__(self):
        self.templocation= tempfile.mkdtemp()

    def imageWriter(self,radar_id, year, month, date, hours):
        print('hello')
        try:
            conn = nexradaws.NexradAwsInterface();
            central_timezone = pytz.timezone('US/Central')
            start = central_timezone.localize(datetime(int(year), int(month), int(date), int(hours), 0))
            end = central_timezone.localize(datetime(int(year), int(month), int(date), int(hours)+1, 0))
            print('hello')
            scans = conn.get_avail_scans_in_range(start, end, radar_id)
            results = conn.download(scans[-1], self.templocation)
            print('hello')
            for result in results.iter_success():
                a=0
                print(a);a+=1
                radar_object = result.open_pyart()

                display = pyart.graph.RadarDisplay(radar_object)
                plt.switch_backend('Agg')
                display.plot('reflectivity', 0, title="{} {}".format(result.radar_id, result.scan_time))
                display.set_limits((-150, 150), (-150, 150))
            plt.savefig('name', format='png')
            path = os.getcwd() + '/' + 'name'
            with open(path, 'rb') as output:
                encoded = base64.b64encode(output.read())
                json = {'image': encoded.decode()}
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




