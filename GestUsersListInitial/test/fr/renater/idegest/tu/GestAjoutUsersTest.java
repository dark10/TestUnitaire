package fr.renater.idegest.tu;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase {
	  /** l'OUT */
	  private GestAjoutUsers gau;                           // 1
	 
	  @Before
	  protected void setUp() throws Exception {
	    try {
	      this.gau = new GestAjoutUsers("testusers.xml");   // 2
	    } catch (IOException e) {
	      fail("Création de l'OUT impossible !");
	    }
	  }
	  
	  @Test
	  public void testUidMinuscule () {
		  String uid = this.gau.genUid("Bob", "Martin");
		  assertEquals("L'UID est en miniscule ",uid.toLowerCase(), uid);
	  }
	  
	  
	  @Test
	  public void testUidLongueur () {
		  String uid = this.gau.genUid("Bob", "Martin");
		  assertTrue("L'UID a une longueur entre 5 et 9",uid.length() >= 5 && uid.length() <= 9 );
	  }
	  
	  
	  @Test
	  public void testUidCaractere () {
		  String uid = this.gau.genUid("Bob", "Martin");
		  String testCarac = "([a-zA-Z0-9]*)";
		  assertTrue("L'UID est conforme",uid.matches(testCarac) );
	  }
	  
	  
	  @Test
	  public void testAddUser () {
		  User uid = gau.addUser("Bob", "Martin");
		  User uid2 = gau.addUser("Bob","Martin");
		  assertTrue("Les UIDs sont differents",uid.getLogin() != uid2.getLogin());
		  
	  }
	  
	  @Test
	  public void testMdp () {
		  User uid = gau.addUser("Bob", "Martin");
		  assertTrue("Les UIDs sont differents",uid.getPass().length() == 8);
	  }
	  
	  @Test
	  public void testMdpdiff () {
		  String pass1 = gau.genPassword(8);
		  String pass2 = gau.genPassword(8);
		  assertTrue("Les UIDs sont differents",pass1 != pass2);
	  }
	}
