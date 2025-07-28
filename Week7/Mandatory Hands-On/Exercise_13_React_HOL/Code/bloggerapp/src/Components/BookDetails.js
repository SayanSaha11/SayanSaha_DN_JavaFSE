import React from "react";
import { books } from "./Books";

const BookDetails = () =>{

    return(
        <ul>
            {books.map(book=>(
                <li key={book.id}>
                    <h3>{book.bookname}</h3>
                    <h4>{book.price}</h4>
                </li>
            ))}
        </ul>
    )
}

export default BookDetails;