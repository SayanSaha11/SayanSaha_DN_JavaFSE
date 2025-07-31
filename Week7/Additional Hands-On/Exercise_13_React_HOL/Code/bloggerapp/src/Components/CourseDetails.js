import { courses } from'./Courses'

const CourseDetails = () =>{
    return(
        <div>
            <ul>
                {courses.map(course=>(
                    <li key={course.id}>
                        <h2>{course.coursename}</h2>
                        <h3>{course.date}</h3>
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default CourseDetails;