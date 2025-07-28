
import './App.css';
import BlogDetails from './Components/BlogDetails';
import BookDetails from './Components/BookDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  return (
    <div className="App">
      <div className='first'>
        <h1>Course Details</h1>
        <CourseDetails/>
      </div>
      <div className='second'>
        <h1>Book Details</h1>
        <BookDetails/>
      </div>
      <div className='third'>
        <h1>Blog Details</h1>
        <BlogDetails/>
      </div>
    </div>
  );
}

export default App;
