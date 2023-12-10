import java.util.Random;

public class QuizWithParticipantsAndMaster {

    public static final int QUESTION_COUNT = 5;
    public static final int PARTICIPANT_COUNT = 2;

    public static void main(String[] args) {
        QuestionMaster questionMaster = new QuestionMaster();
        Participant participant1 = new Participant("Participant 1", questionMaster);
        Participant participant2 = new Participant("Participant 2", questionMaster);

        questionMaster.start();
        participant1.start();
        participant2.start();
    }
}

class QuestionMaster extends Thread {
    private static final int QUESTION_TIMEOUT = 10000;

    @Override
    public void run() {
        for (int i = 1; i <= QuizWithParticipantsAndMaster.QUESTION_COUNT; i++) {
            System.out.println("Question " + i + " from the Question Master");

            synchronized (this) {
                notifyAll();
            }

            try {
                sleep(QUESTION_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Moving to the next question...\n");
        }
    }
}

class Participant extends Thread {
    private final String participantName;
    private final Random random = new Random();
    private final QuestionMaster questionMaster;

    public Participant(String participantName, QuestionMaster questionMaster) {
        this.participantName = participantName;
        this.questionMaster = questionMaster;
    }

    @Override
    public void run() {
        for (int i = 1; i <= QuizWithParticipantsAndMaster.QUESTION_COUNT; i++) {
            synchronized (questionMaster) {
                try {
                    questionMaster.wait();

                    System.out.println(participantName + " is answering Question " + i);

                    int answer = random.nextInt(4) + 1;

                    sleep(1000);

                    System.out.println(participantName + " answered Question " + i + ": " + answer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
