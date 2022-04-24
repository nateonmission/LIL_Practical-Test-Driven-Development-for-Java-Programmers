package ISBNTools;

import Models.Books;

import java.awt.print.Book;

public class StockManager {

    private ExternalISBNDataServices webService;
    public void setWebService(ExternalISBNDataServices webService){
        this.webService= webService;
    }

    private ExternalISBNDataServices dataService;
    public void setDataService(ExternalISBNDataServices dataService){
        this.dataService= dataService;
    }


    public String getLocatorCode(String isbn){
        Books book = dataService.lookup(isbn);
        if(book == null) book = webService.lookup(isbn);     //new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717" );

        String locatorCode = "";
        locatorCode += isbn.length() ==10 ? book.getIsbn_short().substring(6) : book.getIsbn_short().substring(9) ;
        locatorCode += book.getAuthor().substring(0,1);
        locatorCode += book.getTitle().split(" ").length;
        return locatorCode;
    }


}
