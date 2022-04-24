package ISBNTools;

import Models.Books;

public interface ExternalISBNDataServices {

    public Books lookup(String isbn);

}
