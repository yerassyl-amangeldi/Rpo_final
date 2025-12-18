USE library_db;

INSERT INTO publishers (name, country, founded_year, website) VALUES
('Penguin Random House', 'USA', 2013, 'https://www.penguinrandomhouse.com'),
('HarperCollins', 'USA', 1989, 'https://www.harpercollins.com'),
('Simon & Schuster', 'USA', 1924, 'https://www.simonandschuster.com'),
('Macmillan Publishers', 'UK', 1843, 'https://us.macmillan.com'),
('Hachette Livre', 'France', 1826, 'https://www.hachette.com');

INSERT INTO authors (first_name, last_name, birth_date, nationality, biography) VALUES
('George', 'Orwell', '1903-06-25', 'British', 'English novelist, essayist and critic known for 1984 and Animal Farm'),
('Jane', 'Austen', '1775-12-16', 'British', 'English novelist famous for romantic novels about manners'),
('Mark', 'Twain', '1835-11-30', 'American', 'American writer and humorist, author of Tom Sawyer and Huckleberry Finn'),
('Leo', 'Tolstoy', '1828-09-09', 'Russian', 'One of the greatest authors of all time, wrote War and Peace and Anna Karenina'),
('Ernest', 'Hemingway', '1899-07-21', 'American', 'Nobel Prize-winning novelist known for concise style'),
('Virginia', 'Woolf', '1882-01-25', 'British', 'Key figure in modernist literature'),
('F. Scott', 'Fitzgerald', '1896-09-24', 'American', 'Icon of the Jazz Age, author of The Great Gatsby'),
('Gabriel', 'García Márquez', '1927-03-06', 'Colombian', 'Nobel Prize winner, pioneer of magical realism');

INSERT INTO books (title, isbn, publication_date, pages, language, description, publisher_id) VALUES
('1984', '978-0451524935', '1949-06-08', 328, 'English', 'Dystopian novel about totalitarianism and surveillance', 1),
('Animal Farm', '978-0451526342', '1945-08-17', 112, 'English', 'Satirical allegory of the Russian Revolution', 1),
('Pride and Prejudice', '978-0141439518', '1813-01-28', 432, 'English', 'Classic romantic novel of manners', 2),
('The Adventures of Tom Sawyer', '978-0143107330', '1876-06-01', 274, 'English', 'Adventures of a boy growing up in the American South', 2),
('War and Peace', '978-0199232765', '1869-01-01', 1225, 'Russian', 'Epic historical novel about the Napoleonic wars', 3),
('The Old Man and the Sea', '978-0684801223', '1952-09-01', 127, 'English', 'Story of an aging fisherman''s struggle with a giant marlin', 4),
('To the Lighthouse', '978-0156907392', '1927-05-05', 209, 'English', 'Modernist novel exploring consciousness and perception', 5),
('The Great Gatsby', '978-0743273565', '1925-04-10', 180, 'English', 'Tragedy of the American Dream in the Jazz Age', 4),
('One Hundred Years of Solitude', '978-0060883287', '1967-05-30', 417, 'Spanish', 'Magical realist chronicle of the Buendía family', 2);

INSERT INTO book_author (book_id, author_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(6, 5),
(7, 6),
(8, 7),
(9, 8);

INSERT INTO permissions (name, description) VALUES
('ROLE_USER', 'Standard user with read access'),
('ROLE_ADMIN', 'Full system administrator'),
('ROLE_LIBRARIAN', 'Manage books, authors and publishers');

INSERT INTO users (username, password, email, enabled) VALUES
('admin', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'admin@library.com', true),
('librarian', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'librarian@library.com', true),
('user', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'user@library.com', true);

INSERT INTO user_permission (user_id, permission_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 3),
(3, 1);

INSERT INTO users(username, password, email, enabled) VALUES
                                                          ('yerassyl', 'password', 'yerassyl@mail.ru', true)
