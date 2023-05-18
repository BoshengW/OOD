## Library Management System
### MVP minimum viable product
- Borrow Book
  - User -> Borrow Book -> find Book -> mark Book -> receipt
- Return Book
  - User -> Return Book -> find Book -> update status 
- Reservation
  - User -> Reserve Book -> find Book -> provide est day

### Basic Classes
User
- UserID
- List<Book> ownBooks
- +borrow(Book book)
- +return(Book book)
- +reserve(Book book)
- +find(Book book)

BorrowInfo
- isBorrowed
- Est return time
- last borrow date

Book
- BookID
- BookName
- Catagory
- ShelfID
- BorrowInfo
- + getLocation() -> return Shelf.findLocation(BookID)

Shelf
- HashSet<Book>
- ShelfID
- Shelf-Location

ShelfSystem
- HashMap<ShelfID, Shelf> shelves
- findLocation(BookID) -> shelves.get(ShelfID).getShelfLocation()

Library
- HashMap<BookName, List<Book>> BookDataBase
- HashMap<BookID, List<User>> waitList
- HashMap<userID, User> UserDB
- ShelfSystem
- Notify() -> notify all user when book available - Pub-Sub design pattern
- BorrowToUser(Book)
- ReverseToUser(Book)
- ReturnFromUser(Book)
- AddBook(Book)
- removeBook(Book)
