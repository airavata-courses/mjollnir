from http.client import HTTPException

from DAOClass import DAOClass as DAOClass
from datetime import datetime
from flask import Flask, jsonify

app = Flask(__name__)


@app.route('/getImage/<int:year>/<int:month>/<int:date>/<int:startHour>/<int:endHour>/<radarId>', methods=['GET'])
def getImage(year, month, date, startHour, endHour, radarId):
    a = DAOClass()
    result=a.imageWriter(radarId, datetime(year, month, date, startHour, 0), datetime(year, month,date,endHour, 0))
    if result==False:
        raise HTTPException(status_code=404, detail="Radar station is not found")
    else:
        return result


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app.run()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
