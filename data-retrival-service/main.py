from http.client import HTTPException

from DAOClass import DAOClass as DAOClass
from datetime import datetime
from flask import Flask, jsonify, request

app = Flask(__name__)


@app.route('/getImage', methods=['POST'])
def get_image():
    a = DAOClass()
    print(request.is_json)
    print(request.get_json(force=True))
    request_data = request.get_json(force=True)
    result = a.imagewriter(
            request_data['radarId'],
            datetime(
                int(request_data['year']),
                int(request_data['month']),
                int(request_data['date']),
                int(request_data['startHour']), 0),
            datetime(
                int(request_data['year']),
                int(request_data['month']),
                int(request_data['date']),
                int(request_data['endHour']), 0))
    if result is None:
        raise HTTPException(status_code=404, detail="Radar station is not found")
    else:
        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app.run()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
