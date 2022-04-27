from http.client import HTTPException


from datetime import datetime
from flask import Flask, jsonify, request

from metPY import metPY

app = Flask(__name__)


@app.route('/getImage', methods=['POST'])
def get_image():
    a = metPY()
    changeDic={'Jan':'01',
               'Feb':'02',
               'Mar':'03',
               'Apr':'04',
               'May':'05',
               'Jun':'06',
               'Jul':'07',
               'Aug':'08',
               'Sep':'09',
               'Oct':'10',
               'Nov':'11',
               'Dec':'12'}
    print(request.is_json)
    print(request.get_json(force=True))
    request_data = request.get_json(force=True)
    result = a.imageWriter(
            request_data['radarId'],
            request_data['year'],
            changeDic[request_data['month']],request_data['date'],request_data['startHour'])
    if result is None:
        raise HTTPException(status_code=404, detail="Radar station is not found")
    else:
        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app.run()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
