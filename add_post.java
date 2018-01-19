@ResponseBody
	@RequestMapping(value="/add", method = {RequestMethod.POST})
	public SessionInfo add(@RequestParam Integer num_1, @RequestParam Integer num_2, HttpServletRequest req) {

		SessionInfo sessionInfo = new SessionInfo();
		
		try {
				java.math.BigDecimal result_value = new BigDecimal(num_1.floatValue()).add(new BigDecimal(num_2.floatValue()));
		
				sessionInfo.setSessionInfoWithOK(null, "result", result_value);
		
				
		} catch(Exception ex) {
			logger.fatal(ex.getMessage());
			sessionInfo.setSessionInfoWithMethodFailure(null);
		}

		return sessionInfo;
	}