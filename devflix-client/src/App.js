import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MovieCards from './pages/MovieCards';
import MoviePage from './pages/MoviePage';
import Nav from './components/Nav';

function App() {
  return (
    <Router>
      <header class='container-fluid' style={{backgroundColor: 'black', marginLeft: 'auto', marginRight: 'auto'}}>
        <Nav />
      </header>

      <main class='container-fluid' style={{backgroundColor: 'black', marginLeft: 'auto', marginRight: 'auto'}}>
        <Routes>
            <Route 
              path = "/" 
              element = {<MovieCards />} 
            />

            <Route 
              path = "/:id" 
              element = {<MoviePage />} 
            />
        </Routes>
      </main>
    </Router> 
  );
}

export default App;
