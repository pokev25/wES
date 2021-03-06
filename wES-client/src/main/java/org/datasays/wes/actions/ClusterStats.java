package org.datasays.wes.actions;

import okhttp3.HttpUrl;
import org.datasays.wes.core.RequestInfo;
import org.datasays.wes.types.*;
// documentation: https://www.elastic.co/guide/en/elasticsearch/reference/5.x/cluster-stats.html
public class ClusterStats extends RequestInfo{

	public ClusterStats(String baseUrl){
		super(baseUrl);
	}
	public ClusterStats(HttpUrl baseUrl){
		super(baseUrl);
	}

	// param: boolean flatSettings: Return settings in flat format (default: false)
	public ClusterStats flatSettings(boolean flatSettings){
		addParams("flatSettings", flatSettings);
		return this;
	}
	// param: boolean human: Whether to return time and byte values in human-readable format.
	public ClusterStats human(boolean human){
		addParams("human", human);
		return this;
	}
	// param: time timeout: Explicit operation timeout
	public ClusterStats timeout(long timeout){
		addParams("timeout", timeout);
		return this;
	}
	// body:null
	@Override
	public void setBody(Object body) {
		super.setBody(body);
	}

	//A comma-separated list of node IDs or names to limit the returned information; use `_local` to return information from the node you're connecting to, leave empty to get information from all nodes
	private String node_id;
	public ClusterStats setParts(String node_id){
		this.node_id=node_id;

		return this;
	}

	@Override
	public String parseUrl(String method) {
		if(!"GET".equalsIgnoreCase(method)){
			throw new IllegalArgumentException("Unsupported method:"+method);
		}
		//=>/_cluster/stats/nodes/{node_id}
		if(node_id != null ){
			setUrl("_cluster", "stats", "nodes", node_id);
			return super.parseUrl(method);
		}
		//=>/_cluster/stats
		setUrl("_cluster", "stats");
		return super.parseUrl(method);

	}
}
