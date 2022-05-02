from flask import Flask, jsonify, request
# from flask_ngrok import run_with_ngrok
from http.client import HTTPException
import subprocess
import numpy as np
from netCDF4 import Dataset
import matplotlib.pyplot as plt
from cartopy import crs as ccrs
import os
import warnings
from datetime import datetime
import base64

app = Flask(__name__)


# run_with_ngrok(app)

@app.route('/getMeeraImage', methods=['POST'])
def MeeraService():
    request_data = request.get_json(force=True)
    dt = datetime.strptime(request_data['date'], "%d/%m/%Y %H:%M")
    year = dt.year
    month = str(dt.month).zfill(2)
    assimilation = 0
    if year > 2010:
        assimilation = 400
    elif 2000 < year <= 2010:
        assimilation = 300
    elif 1990 < year <= 2000:
        assimilation = 200
    SERVER = 'goldsmr4.gesdisc.eosdis.nasa.gov'
    PATH = 'data/MERRA2_MONTHLY/M2TMNXSLV.5.12.4'
    FILE = 'MERRA2_400.tavgM_2d_slv_Nx'
    FILE = f'MERRA2_{assimilation}.tavgM_2d_slv_Nx'
    url = f"https://{SERVER}/{PATH}/{year}/{FILE}.{year}{month}.nc4"

    start = datetime.now()
    os.system(
        f"wget  --user=kartheek_59 --password=n8YC2y94WZj!UUf -O output3.nc4 {url}")
    end = datetime.now()

    data = Dataset("output3.nc4", "r")
    print(data)
    lons = data.variables['lon'][:]
    lats = data.variables['lat'][:]
    T2M = data.variables['T2M'][:, :, :]
    T2M = T2M[0, :, :]

    # Set the figure size, projection, and extent
    fig = plt.figure(figsize=(8, 4))
    ax = plt.axes(projection=ccrs.Robinson())
    ax.set_global()
    ax.coastlines(resolution="110m", linewidth=1)
    ax.gridlines(linestyle='--', color='black')

    # Set contour levels, then draw the plot and a colorbar
    clevs = np.arange(230, 311, 5)
    plt.contourf(lons, lats, T2M, clevs,
                 transform=ccrs.PlateCarree(), cmap=plt.cm.jet)

    plt.title(
        f'MERRA-2 Air Temperature at 2m, {dt.strftime("%B")} {year}', size=14)
    cb = plt.colorbar(ax=ax, orientation="vertical",
                      pad=0.02, aspect=16, shrink=0.8)
    cb.set_label('K', size=12, rotation=0, labelpad=15)

    cb.ax.tick_params(labelsize=10)
    plt.savefig(
        'output.png')
    #plt.show()
    path = os.getcwd() + '/' + 'output.png'
    with open(path, 'rb') as output:
        encoded = base64.b64encode(output.read())
    json = {'image': encoded.decode()}

    dirs = os.listdir()
    cur_dir = os.getcwd()
    for file in dirs:
        file_path = os.path.join(cur_dir, file)
        if file.endswith('.gz'):
            os.remove(file_path)
        if file.endswith('.png'):
            os.remove(file_path)

    return json


if __name__ == '__main__':
    app.run(host='0.0.0.0',port=7500)
