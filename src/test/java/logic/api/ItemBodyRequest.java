package logic.api;

import java.util.Map;

public class ItemBodyRequest {

    public ItemBodyRequest(String store, int isClub, String supplyAt, Map<String, String> items, Meta meta) {
        this.store = store;
        this.isClub = isClub;
        this.supplyAt = supplyAt;
        this.items = items;
        this.meta = meta;
    }

    private String store;
    private int isClub;
    private String supplyAt;
    private Map<String, String> items;
    private Meta meta;

    // Getters and Setters

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getIsClub() {
        return isClub;
    }

    public void setIsClub(int isClub) {
        this.isClub = isClub;
    }

    public String getSupplyAt() {
        return supplyAt;
    }

    public void setSupplyAt(String supplyAt) {
        this.supplyAt = supplyAt;
    }

    public Map<String, String> getItems() {
        return items;
    }

    public void setItems(Map<String , String> items) {
        this.items = items;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    // Nested Meta class

    public static class Meta {
        private String stag;
        private int uid;
        private int iid;

        // Getters and Setters

        public String getStag() {
            return stag;
        }

        public void setStag(String stag) {
            this.stag = stag;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"store\": ").append(store).append(",");
        sb.append("\"isClub\": ").append(isClub).append(",");
        sb.append("\"supplyAt\": \"").append(supplyAt).append("\",");
        sb.append("\"items\": ").append(mapToString(items)).append(",");
        sb.append("\"meta\": ").append(metaToString(meta)).append("");
        sb.append("}");

        return sb.toString();
    }

    private String mapToString(Map<String , String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map.Entry<String , String> entry : map.entrySet()) {
            sb.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (!map.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Remove the trailing comma and space
        }
        sb.append("}");
        return sb.toString();
    }

    private String metaToString(Meta meta) {
        if (meta == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    stag: \"").append(meta.getStag()).append("\",\n");
        sb.append("    uid: ").append(meta.getUid()).append(",\n");
        sb.append("    iid: ").append(meta.getIid()).append("\n");
        sb.append("  }");
        return sb.toString();
    }
}
