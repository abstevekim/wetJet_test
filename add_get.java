	@ResponseBody
	@RequestMapping(value="/add", method = {RequestMethod.GET})
	public SessionInfo add(@RequestParam Integer num_1, @RequestParam Integer num_2, HttpServletRequest req) {

		SessionInfo sessionInfo = new SessionInfo();
		
		try {
			
				JSONObject resultJsonObject = new JSONObject();
				java.math.BigDecimal result_value = new BigDecimal(num_1.floatValue()).add(new BigDecimal(num_2.floatValue()));
		
				resultJsonObject.put("result_value", result_value);
			
				sessionInfo.setSessionInfoWithOK(null, "result", resultJsonObject);
		
				
		} catch(Exception ex) {
			logger.fatal(ex.getMessage());
			sessionInfo.setSessionInfoWithMethodFailure(null);
		}

		return sessionInfo;
	}
