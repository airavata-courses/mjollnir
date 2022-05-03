import React, { useState } from "react";
import GoogleLogin from "react-google-login";
// import Navbar from "./Navbar";
import 'date-fns'
import Grid from '@material-ui/core/Grid';
import DateFnsUtils from '@date-io/date-fns'
import {MuiPickersUtilsProvider, KeyboardTimePicker, KeyboardDatePicker} from '@material-ui/pickers';
import logo from "../Components/pictures/logo5.png";
import { Link } from "react-scroll";
// REACT FONTAWESOME IMPORTS
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars } from "@fortawesome/free-solid-svg-icons";
import { useForm } from "react-hook-form";
import Stations from './Stations';
import {getRadarStations,sendData, sendMerraData} from '../api_calls.js';
import DisplayImage from "./displayImage";
import im from './im.json'

const Header = () => {

    const [loginData, setLoginData] = useState(
        localStorage.getItem("loginData")
        ? JSON.parse(localStorage.getItem("loginData"))
        : null
    );
    const [encoded_image, setImagedata] = useState('');
    const [encoded_merra_image, setMerraImagedata] = useState('');

    const renderImage=() =>
                {
                
                 sendData().then(res => {
                
                 console.log(res);
            //    const {encoded_image} = res.data.body;
                             if(res) {
                                setImagedata(
                                    "data:image/png;base64," + res
                                )
                             }

                 }).catch(err => {
                 console.log(err);
                 });
                 sendMerraData().then(res => {
                
                    console.log(res);
               //    const {encoded_image} = res.data.body;
                                if(res) {
                                    setMerraImagedata(
                                       "data:image/png;base64," + res
                                   )
                                }
   
                    }).catch(err => {
                    console.log(err);
                    });
                 }

    const handleFailure = (result) => {
        alert(result);
    };

    const handleLogin = async (googleData) => {
    const res = await fetch('/api/google-login', {
      method: 'POST',
      body: JSON.stringify({
        token: googleData.tokenId,
      }),
      headers: {
        'Content-Type': 'application/json',
      },
    });
    const data = await res.json();
    setLoginData(data);
    localStorage.setItem('loginData', JSON.stringify(data));
  };
  const handleLogout = () => {
    localStorage.removeItem('loginData');
    setLoginData(null);
  };

  const [selectedDate, setSelectedDate] = React.useState(
    new Date('2014-08-18T21:11:54')
  );

    const handleDateChange = (date) => {
        setSelectedDate(date);
        localStorage.setItem('selectedDate',selectedDate);
        // console.log(date);
    };
  
    const {handleSubmit} = useForm();

        const onSubmit = (r) => {
            <h3> Hey Hi</h3>  
        r.target.reset();
    }



   
    return (
        <div>
              <nav className="navbar navbar-expand-lg navbar-light bg-black fixed-top">
            <div className="container">

                <a className="navbar-brand" href="#"><img className="logo" src={logo} alt="logo..." /></a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <FontAwesomeIcon icon={faBars} style={{ color: "#fff" }} />
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item active">
                            {/* <Link smooth = {true} to = "home" offset={-110} className="nav-link" href="#">Home <span className="sr-only">(current)</span></Link> */}
                            {/* <Link smooth = {true} to = "home" offset={-110} className="nav-link" href="#">{loginData ? ( <>You are logged in as <h6>{loginData.name}</h6></>):(<h3></h3>)} <span className="sr-only">(current)</span></Link> */}
                            {/* <Link smooth = {true} to = "home" offset={-110} className="nav-link" href="#">{loginData ? ( <button onClick={handleLogout}>Logout</button>):(<h3></h3>)} <span className="sr-only">(current)</span></Link> */}
                        </li>
                        <li className="nav-item">
                            <Link smooth = {true} to = "about" offset={-110} className="nav-link" href="#">{loginData ? ( <>You are logged in as <h6>{loginData.name}</h6></>):(<h3></h3>)}</Link>
                        </li>

                        <li className="nav-item">
                            <Link smooth = {true} to = "about" offset={-110} className="nav-link" href="#">{loginData ? ( <button onClick={handleLogout}>Logout</button>):(<h3></h3>)}</Link>
                        </li>

                    </ul>

                </div>

            </div>
        </nav>
        <div id="home" className="header-wrapper">
            <div className="main-info">

                <h1> Mjölnir </h1>

                <div className="btn-main-offer">
                    {loginData ? (
                    <>
                    <div>
                     <form onSubmit={handleSubmit(onSubmit)}>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                    <div container justify="space-around">
                    <div style={{ display: 'flex', justifyContent: 'space-evenly'}}>
                        <KeyboardDatePicker
                            disableToolbar
                            variant="inline"
                            margin="normal"
                            id="date-picker"
                            label="Select Date"
                            format="MM/dd/yyyy"
                            value={selectedDate}
                            onChange = {handleDateChange}
                            KeyboardButtonProps={{
                                'aria-label': 'change date'
                            }}
                            />
                        <KeyboardTimePicker 
                            margin="normal"
                            id="time-picker"
                            label = 'Select Time'
                            value={selectedDate}
                            onChange = {handleDateChange}
                            KeyboardButtonProps={{
                                'aria-label': 'change time'
                            }}
                            />
                            <div>
                            <Stations/>
                            </div>
                
                    </div>
                            </div>
                            </MuiPickersUtilsProvider>
                    </form>
                    </div>
                    
                    <div style={{ display: 'flex'}}>

                    <DisplayImage image={ encoded_image }/>
                    <DisplayImage image={ encoded_merra_image }/>
                    </div>
                    
                    <button className="btn-main-offer contact-btn" type="submit" onClick={renderImage} >submit</button>
                    
                    </>
                    ) : (
                    
                    <GoogleLogin
                    clientId='332100088618-bu9ktvl1h1hk9fvujl402r8p6k5ih8nc.apps.googleusercontent.com'
                    buttonText="Login with Google Account"
                    onSuccess={handleLogin}
                    onFailure={handleFailure}
                    cookiePolicy={'single_host_origin'}
                    >
                    </GoogleLogin>
                    )}
                   
                </div>
                
            </div>
        </div>
        </div>
    )
}
export default Header