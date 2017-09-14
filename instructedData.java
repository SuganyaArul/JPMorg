
public class instructedData {

	public String entity;
	public String buySell;
	public float agreedFx;
	public String currency;
	public String instructionDate;
	public String settlementDate;
	public Integer units;
	public float pricePerUnit;
	public float amount;

	public instructedData(String entity,String buySell,float agreedFx,String currency,String instructionDate, String settlementDate, Integer units,float pricePerUnit,float amount)
	{
		this.entity=entity;
		this.buySell=buySell;
		this.agreedFx=agreedFx;
		this.currency=currency;
		this.instructionDate=instructionDate;
		this.settlementDate=settlementDate;
		this.units=units;
		this.pricePerUnit=pricePerUnit;
		this.amount=amount;
	}
	public instructedData()
	{
	}
	public String getEntity()
	  { return this.entity;}

	public void setEntity(String enty)
	  { this.entity=enty;}

	public String getBuySell()
	  { return this.buySell;}

	public void setBuySell(String buySel)
	  { this.buySell=buySel;}

	public float getAgreedFx()
	  { return this.agreedFx;}

	public void setAgreedFx(float agree)
	  { this.agreedFx=agree;}

	public String getCurrency()
	  { return this.currency;}

	public void setCurrency(String curr)
	  { this.currency=curr;}

	public String getInstructionDate()
	  { return this.instructionDate;}

	public void setInstructionDate(String insDate)
	  { this.instructionDate=insDate;}

	public String getSettlementDate()
	  { return this.settlementDate;}

	public void setSettlementDate(String setDate)
	  { this.settlementDate=setDate;}

	public int getUnits()
	  { return this.units;}

	public void setUnits(int unit)
	  { this.units=unit;}

	public float getPricePerUnit()
	  { return this.pricePerUnit;}

	public void setPricePerUnit(float price)
	  { this.pricePerUnit=price;}
	
	public float getAmount()
	{ return this.amount;}
	
	public void setAmount(float amount)
	{ this.amount=amount;}




}
