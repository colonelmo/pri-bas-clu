package clustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GraphRepresentation <T>{
	private ArrayList<ClusterRepresentation<T> > clusters; 
	private HashMap<Integer , T> map;
	private ArrayList<EdgeRepresentation<T>> mainList , reserveList;
	
	public void addToMainList(EdgeRepresentation<T> e){
		mainList.add(e);
	}
	public void addToReserveList(EdgeRepresentation<T> e){
		reserveList.add(e);
	}
	
	public ArrayList<EdgeRepresentation<T>> getMainList(){
		return mainList ;
	}
	
	public ArrayList<EdgeRepresentation<T>> getReserveList(){
		return reserveList ;
	}
	
	public GraphRepresentation() {
		mainList = new ArrayList<>();
		reserveList = new ArrayList<>();
		clusters = new ArrayList<>();
	}
	public void add(ClusterRepresentation<T> cl){
		clusters.add(cl);
	}
	
	public void setInverseMap(HashMap<Integer , T> theMap){
		map = theMap;
	}
//	
	public String getGuiOutput(){
		StringBuilder sb = new StringBuilder();
		HashSet<T> nodes = new HashSet<>() ;
		for(EdgeRepresentation<T> e : mainList){
			nodes.add(e.first);
			nodes.add(e.second);
		}
		sb.append(nodes.size());
		sb.append("\n");
		for(T e : nodes){
			sb.append(e);
			sb.append("\n");
		}
		sb.append("\n");
		sb.append(mainList.size());
		sb.append("\n");
		for(EdgeRepresentation<T> e : mainList){
			sb.append(e.first + " " + e.second + " " + e.weight);
			sb.append("\n");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	public ArrayList<ClusterRepresentation<T>> getClusters(){
		return clusters; 
	}
}
