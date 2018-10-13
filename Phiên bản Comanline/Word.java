package dictionarycomanlines;

public class Word {
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
	Word()
	{
		word_target = "";
		word_explain = "";
	}
	Word(String word, String mean)
	{
		word_target = word;
		word_explain = mean;
	}
}
