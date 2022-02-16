from http.client import HTTPException

from DAOClass import DAOClass as DAOClass
from datetime import datetime
from flask import Flask, jsonify, request

app = Flask(__name__)


@app.route('/getImage', methods=['POST'])
def get_image():
    a = DAOClass()
    print(request)
    changeDic={'Jan':'1',
               'Feb':'2',
               'Mar':'3',
               'Apr':'4',
               'May':'5',
               'Jun':'6',
               'Jul':'7',
               'Aug':'8',
               'Sep':'9',
               'Oct':'10',
               'Nov':'11',
               'Dec':'12'}
    print(request.is_json)
    print(request.get_json(force=True))
    request_data = request.get_json(force=True)
    result = a.imagewriter(
            request_data['radarId'],
            datetime(
                int(request_data['year']),
                int(changeDic[request_data['month']]),
                int(request_data['date']),
                int(request_data['startHour']), 0),
            datetime(
                int(request_data['year']),
                int(changeDic[request_data['month']]),
                int(request_data['date']),
                int(request_data['startHour'])+1, 0))
    print("hiiiiiiiiii")
    if result is None:
        raise HTTPException(status_code=404, detail="Radar station is not found")
    else:
        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8000)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
