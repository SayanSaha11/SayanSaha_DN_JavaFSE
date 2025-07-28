import { blogs } from './Blogs'

const BlogDetails = () =>{
    return(
        <ul>
            {blogs.map(blog=>(
                <li key={blog.author}>
                    <h1>{blog.title}</h1>
                    <h3>{blog.author}</h3>
                    <h4>{blog.content}</h4>
                </li>
            ))}
        </ul>
    )
}

export default BlogDetails;