package hash;

import java.util.Iterator;

public class Tester {

	public static void main(String[] args) {
		HashTable ht = new HashTable(20);
		
		ht.put("oviid","KouTPb");
		ht.put("PzIBr","iwTMsF");
		ht.put("GuSWP","BCHhkV");
		ht.put("pPNOU","zBYujV");
		ht.put("mXOwk","MaLngB");
		ht.put("WuOUM","JHXcEv");
		ht.put("wxBUM","alFNnh");
		ht.put("PJfim","bkXtyC");
		ht.put("MaCSm","LjZwcS");
		ht.put("JtToK","FDwFyr");
		ht.put("nbTpl","XcmEPv");
		ht.put("PIeez","lDizbz");
		ht.put("xDotC","oZZmJh");
		ht.put("HOPHf","NbfsVm");
		ht.put("WDoud","nBPKcq");
		ht.put("NNgeD","nBEUeE");
		ht.put("ZuKnt","EwOdei");
		ht.put("frlBE","SnoKus");
		ht.put("UcDBN","SgcKmp");
		ht.put("xDYrx","bGSHCy");
		ht.put("qxYUv","LOvtQA");
		ht.put("PHbcj","TiyKPE");
		ht.put("Oygoh","iVFlNq");
		ht.put("zVxBn","XtynAG");
		ht.put("vnOYk","nuKhgD");
		ht.put("EOIRO","ogsYaP");
		ht.put("zUxAb","xBRrhy");
		ht.put("tQYNF","HsDizC");
		ht.put("OfPVQ","FqyLWL");
		ht.put("BVWIC","nwElpm");
		ht.put("pdEpM","lHXOUO");
		ht.put("xQnEd","oEUXIX");
		ht.put("XVMVN","rHTgbv");
		ht.put("VSvms","yvaZwI");
		ht.put("HsnQR","pOEKEy");
		ht.put("xYUIF","jlWUlh");
		ht.put("QGdvI","UXuIQN");
		ht.put("JoISe","qWBrnm");
		ht.put("iblnV","uvsyET");
		ht.put("imczt","fShOba");
		int count = 1;
		Iterator itr = ht.keys();
	      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.println(count + ": " + element + " ");
	         count++;
	      }
//CODE USED TO GENERATE TEST CASES
	      
//	      from random import randint
//
//	      def newLetter():
//	          case = randint(0,1)
//	          
//	          if case == 0:
//	              return chr(randint(ord('a'), ord('z')))
//	          else:
//	              return  chr(randint(ord('A'), ord('Z')))
//	              
//	      def newString(size: int):
//	          str = ""
//	          for i in range(size):
//	              str += newLetter();
//	              
//	          return str
//
//	      count = 0
//	      while (count < 40):
//	          print('ht.put("{str}","{rat}");'.format(str = newString(5), rat= newString(6)))
//	          count+= 1
		
	}

}
