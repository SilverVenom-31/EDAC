import React, { Component } from 'react';

class Weather extends Component{
    /* state={
        details:[
            {day:"Monday", date_time: "Januray 1st 6:00 AM"},
            {day:"Tuesday", date_time: "Januray 1st 6:00 AM"},
            {day:"Wednesday", date_time: "Januray 1st 6:00 AM"},
            {day:"Thursday", date_time: "Januray 1st 6:00 AM"},
            {day:"Friday", date_time: "Januray 1st 6:00 AM"},
            {day:"Saturday", date_time: "Januray 1st 6:00 AM"},
            {day:"Sunday", date_time: "Januray 1st 6:00 AM"},
        ]
    } */


    render(){

        const details = [
            {day:"Monday", date_time: "Januray 1st 6:00 AM"},{day:"Tuesday", date_time: "Januray 1st 6:00 AM"},
            {day:"Wednesday", date_time: "Januray 1st 6:00 AM"},
            {day:"Thursday", date_time: "Januray 1st 6:00 AM"},
            {day:"Friday", date_time: "Januray 1st 6:00 AM"},
            {day:"Saturday", date_time: "Januray 1st 6:00 AM"},
            {day:"Sunday", date_time: "Januray 1st 6:00 AM"},
        ]
        const updateddetails = details.map(detail => {
            return (
                <div className="container row App">
                    <div className='col-sm-2 card'>
                    
                       <h3>{detail.day}</h3><br></br>
                       <p>{detail.date_time}</p>
                    
                    </div>  
                </div>         
            )
        });

        return(
            <div className="container">
                <div>
                    <div>
                        <h2 className="weather App">Weather Details</h2>
                    </div>

                    <div>
                        <h3 className="App">Jaipur, India</h3>
                    </div>
                {/* <div>
                    {this.state.list.map(ele => {
                         <div className='col-sm-2 card'>
                            <h3>{ele.day}</h3>
                            <p className='text-muted'>{ele.date_time}</p>
                        </div>
                    })
                    }
                </div> */}
                {updateddetails}

                </div>
            </div>
            
        );
    }
}

export default Weather;