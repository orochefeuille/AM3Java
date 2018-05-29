package am3Utils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

public class ConnexionsU {  
	
	private String publicIP;
	private ArrayList<String> addr;
	private InetAddress add;
	
	public ConnexionsU(){
		
		publicIP="";
		addr=new ArrayList<String>();
		
		this.getPublicAddress();
		this.getLanAddress();
		this.getLocalAddress();
	}
	
	public  String findIP(String site, String prefixe, String suffixe) throws Exception {         
	       Scanner sc = new Scanner(new URL(site).openStream()); 
	       while (sc.hasNextLine()) { 
	           String line = sc.nextLine(); 
	           int a = line.indexOf(prefixe); 
	           if (a!=-1) { 
	               int b = line.indexOf(suffixe,a); 
	               if (b!=-1) { 
	                   sc.close(); 
	                   return line.substring(a+prefixe.length(),b); 
	                } 
	            } 
	        } 
	        sc.close(); 
	        return null; 
	} 
	
	private void getPublicAddress(){
		try {
			publicIP=this.findIP("http://votreip.free.fr/","<title>IP : ","</title>");
			System.out.println(publicIP); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getLanAddress(){
		
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			 
        while (interfaces.hasMoreElements()) {  
        	NetworkInterface currentInterface = interfaces.nextElement();
 
           //chaque carte réseau peut disposer de plusieurs adresses IP
        	Enumeration<InetAddress> addresses = currentInterface.getInetAddresses(); 
        	
           while (addresses.hasMoreElements()) { 
        	  
        	   InetAddress currentAddress = addresses.nextElement();
        	   
       		    addr.add(currentAddress.getHostAddress());
        	   
               System.out.println(currentAddress.getHostAddress());
           }
           
        } 
        System.out.println("addr "+addr.indexOf(addr.get(1))+" : "+addr.get(1));
        
       
        InetSocketAddress sa2 =
        	new InetSocketAddress(addr.get(1),50);
        	System.out.println("sa2 :"+ (sa2.isUnresolved()?" non résolue":" résolue -->"+sa2));
        } catch (SocketException e) {
			e.printStackTrace();
		}
 	}
	
	private void getLocalAddress(){
		try {
			 add=InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("add :"+add);
	}

	public String getPublicIP() {
		return publicIP;
	}

	public void setPublicIP(String publicIP) {
		this.publicIP = publicIP;
	}

	public ArrayList<String> getAddr() {
		return addr;
	}

	public void setAddr(ArrayList<String> addr) {
		this.addr = addr;
	}

	public InetAddress getAdd() {
		return add;
	}

	public void setAdd(InetAddress add) {
		this.add = add;
	}
}
