package controller;

import java.util.ArrayList;

public abstract class IFObjectValidator {

	ArrayList<IFRule> al = new ArrayList<IFRule>();

	public abstract void loader();

	public clResultObjectSet evaluate(String ruleSetName, clFeed feed) {

		IFRuleSet ruleSet = loadRuleSet(ruleSetName);

		clResultObjectSet resultSet = ruleSet.evaluate(feed);
		
		return resultSet;
	}

	private IFRuleSet loadRuleSet(String ruleSetName) {
		IFRuleSet ruleSet = null;
		Class<?> cls = null;
		
		try {
			cls = Class.forName(ruleSetName);
		
			try {
				ruleSet = (IFRuleSet) cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ruleSet;
	}

}
