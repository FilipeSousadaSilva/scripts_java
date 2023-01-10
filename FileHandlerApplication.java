public class FileHandlerApplication {

	public static void main(String[] args) throws IOException {
		process();
	}

	private static void process() throws IOException {
		val reader = new BufferedReader( new FileReader("src/main/java/br/com/scripts_java/configmap_input.txt"));
		val writer = new BufferedWriter(new FileWriter("src/main/java/br/com/scripts_java/output.txt"));
		String line = reader.readLine();
		while (line != null){
			writeOutput(processLine(line),writer);
			line = reader.readLine();
		}
		writer.close();
	}

	public static String processLine(String line){
		String[] keyValue = line.split("=",2);
		if(keyValue.length>1){
			keyValue[0] = keyValue[0].replace(".","_");
			keyValue[0] = keyValue[0].replace("-","_");
			if (keyValue[0].startsWith("#")){
				return "";
			}
			keyValue[0] = keyValue[0].toUpperCase();
			String lineProcessed = keyValue[0]+": "+'"'+keyValue[1]+'"';
			System.out.println(lineProcessed);
			return lineProcessed;
		}
		return "";
	}

	public static void writeOutput(String line, BufferedWriter writer) throws IOException {
		writer.write(line);
		writer.write(System.getProperty("line.separator"));
	}
}
