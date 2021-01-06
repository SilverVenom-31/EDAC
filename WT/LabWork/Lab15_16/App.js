import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react'; 
import Header from './NewsHeader/Header'
import Content from './NewsContent/Content'

class App extends Component {
  render(){
  return (
      <div className="container-fluid">
        <div className="row">
            <div className="col-12">
                <Header > </Header>
            </div>

            <div className="col-md-4 col-12 mp-2">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        <br/>
            <div className="col-md-4 col-12">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        <br/>
            <div className="col-md-4 col-12">
                <Content subheading = "MP moves HC for ‘English only’ communication between Centre and State" 
                  article = "Madurai Member of Parliament Su. Venkatesan on Friday moved the Madurai Bench of the Madras High Court, seeking a direction to the Centre to ensure that all communications between the Centre and Tamil Nadu were in English alone. Mr. Venkatesan, who represents the CPI (M),was upset over a reply sent to him in Hindi by Union Minister of State for Home Affairs Nityanand Rai recently." 
                  />
            </div>
        </div>
      </div>

   
  );
}
}

export default App;
