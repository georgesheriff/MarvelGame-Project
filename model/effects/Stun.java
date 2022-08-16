package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Stun extends Effect {

	public Stun(int duration) {
		super("Stun", duration, EffectType.DEBUFF);
	}

	@Override
	public void apply(Champion c) {
		
		c.setCondition(Condition.INACTIVE);
		
		
	}

	@Override
	public void remove(Champion c) {
		int countStun = 0;
		int countRoot = 0;
		
		for(Effect effect : c.getAppliedEffects()) {
			if(effect instanceof Stun) 
				countStun++;
			else if(effect instanceof Root) 
				countRoot++;
		}
		if(countStun==0) {
			if(countRoot==0) c.setCondition(Condition.ACTIVE);
			else c.setCondition(Condition.ROOTED);
		}
		
	}


}
