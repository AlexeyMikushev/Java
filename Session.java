    import javafx.util.Pair;
    import java.io.Serializable;
    import java.util.Map;

    public class Session implements Serializable{
        public Map<Subjects, Integer> subjects;

        public Pair<Integer, Integer> getStatistics() {
         int sum = 0;

         for (Map.Entry<Subjects, Integer> subject : subjects.entrySet()) {
             sum += subject.getValue();
//             return new Pair<Integer, Integer>(sum, subjects.size());


         }
        return new Pair<Integer, Integer>(sum, subjects.size());
     }

        public double getAverageMark() {
            Pair<Integer, Integer> statistics = getStatistics();
            return statistics.getKey() / statistics.getValue();
        }
    }