    @SuppressWarnings("unchecked")
    private String getOrderId(Map<String, Object> map) {
        Map<String, Object> message = (Map<String, Object>) map.get("Message");
        if (message == null) {
            return "";
        }
        return getStringValue(message, "order_id");
    }


   
   // @SuppressWarnings("unchecked")
    // private String getDebiturAreaBranchDesc(Map<String, Object> map) {

    // Map<String, Object> message = (Map<String, Object>) map.get("Message");
    // if (message == null)
    // return "";

    // Map<String, Object> detail = (Map<String, Object>) message.get("detail");
    // if (detail == null)
    // return "";

    // Map<String, Object> debitur = (Map<String, Object>) detail.get("debitur");
    // if (debitur == null)
    // return "";

    // Map<String, Object> personal = (Map<String, Object>) debitur.get("personal");
    // if (personal == null)
    // return "";

    // return getStringValue(personal, "debitur_area_branch_desc");
    // }

    // private String getStringValue(Map<String, Object> map, String key) {
    // return map.get(key) != null ? map.get(key).toString() : "";
    // }