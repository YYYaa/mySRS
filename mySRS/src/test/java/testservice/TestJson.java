package testservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestJson {
	public static void main(String[] args) throws JSONException {
	    String jsonString="{\"users\":[{\"loginname\":\"zhangfan\",\"password\":\"userpass\",\"email\":\"10371443@qq.com\"},{\"loginname\":\"zf\",\"password\":\"userpass\",\"email\":\"822393@qq.com\"}]}";  
	    JSONObject json= new JSONObject(jsonString);  
	    JSONArray jsonArray=json.getJSONArray("users");  
	    String loginNames="loginname list:";  
	    for(int i=0;i<jsonArray.length();i++){  
	        JSONObject user=(JSONObject) jsonArray.get(i);  
	        String userName=(String) user.get("loginname");  
	        if(i==jsonArray.length()-1){  
	            loginNames+=userName;  
	        }else{  
	            loginNames+=userName+",";  
	        }  
	    }  
	    System.out.println(json.toString());
	}  
}
