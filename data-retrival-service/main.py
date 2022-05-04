from http.client import HTTPException


from datetime import datetime
from flask import Flask, jsonify, request

from metPY import metPY

app = Flask(__name__)


@app.route('/getImage', methods=['POST'])
def get_image():
<<<<<<< HEAD
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
=======
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
>>>>>>> 28d1f341c4370071366f59059c489be355811cd1
               'Oct':'10',
               'Nov':'11',
               'Dec':'12'}
    print(request.is_json)
    print(request.get_json(force=True))
    request_data = request.get_json(force=True)
    result = a.imageWriter(
            request_data['radarId'],
<<<<<<< HEAD
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
=======
            request_data['year'],
            changeDic[request_data['month']],request_data['date'],request_data['startHour'])
>>>>>>> 28d1f341c4370071366f59059c489be355811cd1
    if result is None:
        raise HTTPException(status_code=404, detail="Radar station is not found")
    else:
        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
<<<<<<< HEAD
    app.run(host='0.0.0.0', port=8000)
=======
    app.run(host='0.0.0.0',port=5000)
>>>>>>> 28d1f341c4370071366f59059c489be355811cd1

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
