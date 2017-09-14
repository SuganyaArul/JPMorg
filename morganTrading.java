import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class morganTrading {
	public static void main(String[] args) throws ParseException
	  {
		ArrayList<instructedData> insData = new ArrayList<instructedData>();
		int count=0;
		
		instructedData data = new instructedData();
		data.setEntity("foo");
		data.setBuySell("B");
		data.setAgreedFx(0.50f);
		data.setCurrency("SGP");
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date tempDate=newDateFormat.parse("12/09/2017");
		String formattedDate = newDateFormat.format(tempDate);
		data.setInstructionDate(formattedDate);
		Date tempDate1=newDateFormat.parse("16/09/2017");
		String formattedDate1 = newDateFormat.format(tempDate1);
		data.setSettlementDate(formattedDate1);
		data.setUnits(500);
		data.setPricePerUnit(100.25f);
		data.setAmount(0.0f);
		insData.add(data);

		instructedData data1 = new instructedData();
		data1.setEntity("bar");
		data1.setBuySell("S");
		data1.setAgreedFx(0.22f);
		data1.setCurrency("AED");
		Date tempDate2=newDateFormat.parse("12/09/2017");
		String formattedDate2 = newDateFormat.format(tempDate2);
		data1.setInstructionDate(formattedDate2);
		Date tempDate3=newDateFormat.parse("20/09/2017");
		String formattedDate3 = newDateFormat.format(tempDate3);
		data1.setSettlementDate(formattedDate3);
		data1.setUnits(450);
		data1.setPricePerUnit(150.5f);
		data1.setAmount(0.0f);
		insData.add(data1);
		
		instructedData data2 = new instructedData();
		data2.setEntity("bar");
		data2.setBuySell("S");
		data2.setAgreedFx(0.35f);
		data2.setCurrency("SAR");
		Date tempDate4=newDateFormat.parse("14/09/2017");
		String formattedDate4 = newDateFormat.format(tempDate4);
		data2.setInstructionDate(formattedDate4);
		Date tempDate5=newDateFormat.parse("18/09/2017");
		String formattedDate5 = newDateFormat.format(tempDate5);
		data2.setSettlementDate(formattedDate5);
		data2.setUnits(300);
		data2.setPricePerUnit(125.5f);
		data2.setAmount(0.0f);
		insData.add(data2);
		for(int i=0;i<insData.size();i++)
		{
						
			String check=insData.get(i).getSettlementDate();
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(check);
			String currencyCheck=insData.get(i).getCurrency();
			if(currencyCheck == "AED" || currencyCheck == "SAR")
			{
				Calendar cal1=Calendar.getInstance();
				cal1.setTime(date1);
				int days=cal1.get(Calendar.DAY_OF_WEEK);
				if(days == 6)
				{
				Calendar cal2=Calendar.getInstance();
				cal2.setTime(date1);
				cal2.add(Calendar.DATE, 2);
				String changedDate=newDateFormat.format(cal2.getTime());
				insData.get(i).setSettlementDate(changedDate);
				System.out.println("Since Settlement Date fall on weekend for "+ insData.get(i).getEntity()+ " ,Changed the date to next working day");
				}
				else if(days == 7)
				{
				Calendar cal=Calendar.getInstance();
				cal.setTime(date1);
				cal.add(Calendar.DATE, 1);
				String changedDate=newDateFormat.format(cal.getTime());
				insData.get(i).setSettlementDate(changedDate);
				System.out.println("Since Settlement Date fall on weekend for "+ insData.get(i).getEntity()+ " ,Changed the date to next working day");
				}
					
			}
			else
			{
				Calendar cal1=Calendar.getInstance();
				cal1.setTime(date1);
				int days=cal1.get(Calendar.DAY_OF_WEEK);
				if(days == 1)
				{
				Calendar cal2=Calendar.getInstance();
				cal2.setTime(date1);
				cal2.add(Calendar.DATE, 1);
				String changedDate=newDateFormat.format(cal2.getTime());
				insData.get(i).setSettlementDate(changedDate);
				System.out.println("Since Settlement Date fall on weekend for "+ insData.get(i).getEntity()+ " ,Changed the date to next working day");
				}
				else if(days == 7)
				{
				Calendar cal=Calendar.getInstance();
				cal.setTime(date1);
				cal.add(Calendar.DATE, 2);
				String changedDate=newDateFormat.format(cal.getTime());
				insData.get(i).setSettlementDate(changedDate);
				System.out.println("Since Settlement Date fall on weekend for "+ insData.get(i).getEntity()+ " ,Changed the date to next working day");
				}
					
				
				
				
			}
			Calendar calendar=Calendar.getInstance();
			String now=newDateFormat.format(calendar.getTime());
			Date d=new SimpleDateFormat("dd/MM/yyyy").parse(now);
			Calendar calendar1=Calendar.getInstance();
			Calendar calendar2=Calendar.getInstance();
			calendar1.setTime(date1);
			calendar2.setTime(d);
			if(insData.get(i).getBuySell() == "B")
			{		
			
			
			if(calendar1.equals(calendar2))
			{
				count++;
				System.out.println("Amount settled for outgoing today in USD for "+insData.get(i).getEntity());
				System.out.println((insData.get(i).getPricePerUnit())*(insData.get(i).getUnits())*(insData.get(i).getAgreedFx()));
				insData.get(i).setAmount((insData.get(i).getPricePerUnit())*(insData.get(i).getUnits())*(insData.get(i).getAgreedFx()));
			}
			}
			else
			{		
						
			if(calendar1.equals(calendar2))
			{
				count++;
				System.out.println("Amount settled for incoming today in USD for "+insData.get(i).getEntity());
				System.out.println((insData.get(i).getPricePerUnit())*(insData.get(i).getUnits())*(insData.get(i).getAgreedFx()));
				insData.get(i).setAmount((insData.get(i).getPricePerUnit())*(insData.get(i).getUnits())*(insData.get(i).getAgreedFx()));
			}
			}
			if(i==insData.size()-1)
			{
				if(count==0)
					System.out.println("No Amount to be settled today.");
			}
				
			

		}
		float max=0.0f;
		String enty="No ranking because no instructs settled today";
		for(int i=0;i<insData.size();i++)
		{
			float amt=insData.get(i).getAmount();
			if(amt>max)
			{
				String buy=insData.get(i).getBuySell();
				if(buy=="B")
				enty=insData.get(i).getEntity()+"instructs the highest amount for buy instruction";
				else
					enty=insData.get(i).getEntity()+" instructs the highest amount for sell instruction";
			}
			
		}
		System.out.println(enty);
		
	  }
	  
}
