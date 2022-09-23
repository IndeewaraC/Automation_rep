package com.automation.isq.utils.files;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.NodeList;

public class JSONReader extends FileReader{

	@Override
	public void readFile(String path) throws Exception {
		this.readFileAsString(path);
	}

	@Override
	public NodeList getNodeList(String nodeName) throws Exception {
        throw new NotImplementedException();
	}

    @Override
    public Map<String, String> getNode(String path, Object json) throws Exception{
        JsonPathGenerator iter = new JsonPathGenerator(path);
        return getTypeStringMap(iter, json);
    }


    /*
     * Helper Methods
     */
    private static Object getVal(JsonPathGenerator path, Object obj) throws Exception{
        String objType;
        try{
            objType = obj.getClass().getSimpleName();
        }catch (Exception e){
            throw new Exception("InvalidPath");
        }

        String next = path.next();

        if(next == null){ return obj; }

        switch(objType){
            case "JSONObject": {
                JSONObject jsonObject = (JSONObject) obj;
                return JSONReader.getVal(path, jsonObject.get(next));
            }

            case "JSONArray": {
                JSONArray jsonArray = (JSONArray) obj;
                int index = Integer.parseInt(next.replaceAll("(\\[)|(\\])", ""));
                return JSONReader.getVal(path, jsonArray.get(index));
            }

            default: {
                return obj;
            }
        }
    }

    private static Map<String, String> getTypeStringMap(JsonPathGenerator iter, Object json) throws Exception{

        Object result = JSONReader.getVal(iter, json);
        String type = result.getClass().getSimpleName();
        Map<String, String> returnHash = new HashMap();

        switch(type){
            case "String":{
                returnHash.put("value", (String)result);
                returnHash.put("type", type);
                return returnHash;
            }
            case "Integer":{
                returnHash.put("value", Integer.toString((int)result));
                returnHash.put("type", type);
                return returnHash;
            }
            case "Boolean":{
                returnHash.put("value", String.valueOf(result));
                returnHash.put("type", type);
                return returnHash;
            }
            default:{
                returnHash.put("value", result.toString());
                returnHash.put("type", type);
                return returnHash;
            }
        }
    }

    public static void main(String... args) throws Exception{
        JSONReader jr = new JSONReader();
        JSONParser parser = new JSONParser();
        Object jsonObj = parser.parse("{ \"array\": [ 1, 2, 3 ], \"boolean\": true, \"null\": null, \"number\": 123, \"object\": { \"a\": \"b\", \"c\": \"d\", \"e\": \"f\" }, \"string\": \"Hello World\" }");
        try{
            System.out.println(jr.getNode("array[1]", jsonObj).get("value"));
        }catch(Exception e){

        }
    }
}

class JsonPathGenerator{
    String[] paths;
    int i = 0;

    public JsonPathGenerator(String pathStr){
        String pattern = "(?=\\[)|(\\.)";
        this.paths = pathStr.split(pattern);
    }

    public String next(){
        if(i < paths.length){
            String val = paths[i];
            i++;
            return val;
        }
        else
            return null;
    }
}
