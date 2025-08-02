package mymockito;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalcApplicationMockitoTester 
{

	@InjectMocks 
	CalcApplication mathApplication = new CalcApplication();//

	@Mock//interface name
	calcservices calcService;

	@Test
	public void testAdd()
	{
		
		   Mockito.when(calcService.add(10,20)).thenReturn(30);//interface method
		   Mockito.when(calcService.add(10,10)).thenReturn(20);//interface method
	
		   
		   assertEquals(mathApplication.add_1(10, 20),30);//internally calling interface method
		   assertEquals(mathApplication.add_1(10, 10),20);

		  

	}
}

