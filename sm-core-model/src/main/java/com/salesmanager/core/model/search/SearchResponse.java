package com.salesmanager.core.model.search;

import java.util.List;
import java.util.Map;

public class SearchResponse {

	private long totalCount = 0;//total number of entries
	private long entryCount = 0;//number of entries asked

	private List<SearchEntry> entries;
	private Map<String, List<SearchFacet>> facets;//facet key (example : category) & facet description (example : category code)

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(long entryCount) {
		this.entryCount = entryCount;
	}

	public List<SearchEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<SearchEntry> entries) {
		this.entries = entries;
	}

	public Map<String, List<SearchFacet>> getFacets() {
		return facets;
	}

	public void setFacets(Map<String, List<SearchFacet>> facets) {
		this.facets = facets;
	}

}
