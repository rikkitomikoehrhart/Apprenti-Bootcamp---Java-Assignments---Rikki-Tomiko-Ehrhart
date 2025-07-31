import Welcome from './components/Welcome';
import Profile from './components/Profile';
import Profile2 from './components/Profile2';
import Welcome2 from './components/Welcome2';
import Welcome3 from './components/Welcome3';
import Welcome4 from './components/Welcome4';
import Card from './components/Card';

function App() {
 
  return (
    <>
      <Welcome name="Rikki" />
      <Profile 
        name="Rikki Tomiko Ehrhart"
        age={38}
        isPremium={true}
        interests={["Dungeons and Dragons", "TV", "Movies", "My Husband"]}
      />

      <hr/>
      <Profile2 
        name="Rikki Tomiko Ehrhart"
        age={38}
        isPremium={true}
        interests={["Dungeons and Dragons", "TV", "Movies", "My Husband"]}
      />

      <hr />
      <Card>
        <h5 className="card-title">This is my title</h5>
        <p className="card-text">
          All of the content inside the Card tag is bound to the children prop.
        </p>
      </Card>

      <hr />
      <Welcome2 name="Rikki" id="Rikki1" className="green"/>
      <Welcome2 name="Rikki" id="Rikki2" className="blue"/>

      <hr />
      <Welcome3 name="Rikki" id="Rikki1" className="green"/>
      <Welcome3 name="Rikki" id="Rikki2" className="blue"/>
      
      <hr />
      <Welcome4 name="Rikki" id="Rikki1" className="green"/>
      <Welcome4/>
    </>
  );
};

export default App;
