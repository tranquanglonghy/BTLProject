package dictionary;
public class word {
	
	private String word_target;
	private String word_explain;
	
	public void set_word(String word) {
		word_target = word;
	}
	public void set_mean(String mean) {
		word_explain = mean;
	}
	public String get_word() {
		return this.word_target;
	}
	public String get_mean() {
		return this.word_explain;
	}
	public word()
	{
		word_target = "";
		word_explain = "";
	}
	public word(String word, String mean)
	{
		word_target = word;
		word_explain = mean;
	}
        
}