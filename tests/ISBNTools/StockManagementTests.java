package ISBNTools;

import Models.Books;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StockManagementTests {


    ExternalISBNDataServices webService;
    ExternalISBNDataServices dataService;
    StockManager stockManager;

    @Before
    public void setup(){
        webService = mock(ExternalISBNDataServices.class);
        dataService = mock(ExternalISBNDataServices.class);
        stockManager = new StockManager();
    }

    @Test
    public void getValidLocatorCode(){

        // TEST STUB - Replaces an external dependency
//        ExternalISBNDataServices testWebService = new ExternalISBNDataServices() {
//            @Override
//            public Books lookup(String isbn) {
//                return new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717" );
//            }
//        };

        when(webService.lookup("0806512717")).thenReturn(new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717"));

        // TEST STUB - Replaces an external dependency
//        ExternalISBNDataServices testDataService = new ExternalISBNDataServices() {
//            @Override
//            public Books lookup(String isbn) {
//                return null; //new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717" );
//            }
//        };

        when(dataService.lookup("0806512717")).thenReturn(new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717"));

        String isbn = "0806512717";
        stockManager.setWebService(webService);
        stockManager.setDataService(dataService);
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("2717B5", locatorCode);
    }

    @Test
    public void dbIsUsed(){
        when(dataService.lookup("0806512717")).thenReturn(new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717"));

        String isbn = "0806512717";
        stockManager.setWebService(webService);
        stockManager.setDataService(dataService);
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(dataService, times(1)).lookup(isbn);
        verify(webService, times(0)).lookup(anyString());
    }

    @Test
    public void webServiceIsUsed(){
        when(dataService.lookup("0806512717")).thenReturn(null);
        when(webService.lookup("0806512717")).thenReturn(new Books("How to Learn any Language", "Barry Farber", "9780806512716", "0806512717"));

        String isbn = "0806512717";
        stockManager.setWebService(webService);
        stockManager.setDataService(dataService);
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(webService, times(1)).lookup(isbn);
    }


}
