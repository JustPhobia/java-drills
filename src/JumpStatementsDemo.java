public class JumpStatementsDemo {

    // --------------------------------------------------
    // ENUM: Represents how execution FLOW was altered
    // --------------------------------------------------
    enum FlowEvent {
        NORMAL,
        CONTINUE,
        BREAK,
        RETURN
    }

    // --------------------------------------------------
    // MAIN ENTRY POINT
    // --------------------------------------------------
    public static void main(String[] args) throws InterruptedException {

        title();

        demonstrateBreak();
        divider();

        demonstrateContinue();
        divider();

        demonstrateReturn();
        divider();

        conclusion();
    }

    // --------------------------------------------------
    // BREAK DEMONSTRATION
    // --------------------------------------------------
    static void demonstrateBreak() throws InterruptedException {

        narrator("BREAK STATEMENT", "A loop that was meant to finish... but didn't.");

        int intendedIterations = 10;
        int executedIterations = 0;
        FlowEvent flow = FlowEvent.NORMAL;

        narrator("PLAN",
                "• Loop should run " + intendedIterations + " times",
                "• Each iteration represents \"work\"",
                "• Something catastrophic happens at iteration 5");

        pause(1200);

        for (int i = 1; i <= intendedIterations; i++) {

            executedIterations++;

            animate("Loop iteration " + i + " executing...");
            pause(600);

            if (i == 5) {
                flow = FlowEvent.BREAK;
                animate("💥 BREAK encountered — exiting loop NOW");
                pause(800);
                break;
            }
        }

        results(
                "BREAK RESULTS",
                intendedIterations,
                executedIterations,
                flow,
                "The loop was TERMINATED immediately.",
                "Iterations 6–10 never executed."
        );
    }

    // --------------------------------------------------
    // CONTINUE DEMONSTRATION
    // --------------------------------------------------
    static void demonstrateContinue() throws InterruptedException {

        narrator("CONTINUE STATEMENT", "A loop that keeps going, but skips work.");

        int intendedIterations = 10;
        int processedIterations = 0;
        int skippedIterations = 0;
        FlowEvent flow = FlowEvent.NORMAL;

        narrator("PLAN",
                "• Loop runs from 1 to " + intendedIterations,
                "• Iterations 4 and 7 are invalid",
                "• Those iterations will be skipped");

        pause(1200);

        for (int i = 1; i <= intendedIterations; i++) {

            animate("Iteration " + i + " begins...");
            pause(500);

            if (i == 4 || i == 7) {
                skippedIterations++;
                flow = FlowEvent.CONTINUE;
                animate("⏭ CONTINUE — skipping iteration " + i);
                pause(500);
                continue;
            }

            processedIterations++;
            animate("✅ Work completed for iteration " + i);
            pause(500);
        }

        results(
                "CONTINUE RESULTS",
                intendedIterations,
                processedIterations + skippedIterations,
                flow,
                "The loop was NEVER terminated.",
                "Some iterations simply skipped their work."
        );

        System.out.println("• Processed iterations: " + processedIterations);
        System.out.println("• Skipped iterations   : " + skippedIterations);
    }

    // --------------------------------------------------
    // RETURN DEMONSTRATION
    // --------------------------------------------------
    static void demonstrateReturn() throws InterruptedException {

        narrator("RETURN STATEMENT", "A method that exits mid-execution.");

        FlowEvent flow = FlowEvent.NORMAL;

        narrator("PLAN",
                "• Method performs multiple steps",
                "• If energy runs out, execution stops",
                "• Remaining code is abandoned");

        pause(1200);

        animate("Entering method...");
        pause(600);

        animate("Performing step 1...");
        pause(600);

        animate("Performing step 2...");
        pause(600);

        int energy = 0; // Trigger return

        if (energy == 0) {
            flow = FlowEvent.RETURN;
            animate("🚪 RETURN executed — exiting method immediately");
            pause(800);
            returnResults(flow);
            return;
        }

        // NEVER EXECUTES
        animate("Performing step 3...");
    }

    // --------------------------------------------------
    // OUTPUT HELPERS
    // --------------------------------------------------
    static void title() throws InterruptedException {
        System.out.println("\n🎓 JUMP STATEMENT VISUALIZER 🎓");
        System.out.println("Teaching break, continue, and return through execution flow\n");
        pause(1200);
    }

    static void narrator(String title, String... lines) {
        System.out.println("\n📘 " + title);
        for (String line : lines) {
            System.out.println("   " + line);
        }
        System.out.println();
    }

    static void animate(String text) {
        System.out.print("\r" + text + "                     ");
    }

    static void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    static void divider() throws InterruptedException {
        pause(1000);
        System.out.println("\n-----------------------------------------------\n");
        pause(1000);
    }

    static void results(String title,
                        int intended,
                        int executed,
                        FlowEvent flow,
                        String... explanations) {

        System.out.println("\n📊 " + title);
        System.out.println("• Intended iterations: " + intended);
        System.out.println("• Executed iterations: " + executed);
        System.out.println("• Flow event          : " + flow);

        System.out.println("\n🧠 Explanation:");
        for (String e : explanations) {
            System.out.println("• " + e);
        }
    }

    static void returnResults(FlowEvent flow) {

        System.out.println("\n📊 RETURN RESULTS");
        System.out.println("• Flow event: " + flow);

        System.out.println("\n🧠 Explanation:");
        System.out.println("• RETURN exits the method immediately.");
        System.out.println("• Any code below it is unreachable.");
        System.out.println("• Control returns to the caller.");
    }

    static void conclusion() throws InterruptedException {
        pause(1200);
        System.out.println("\n🏁 CONCLUSION");
        System.out.println("• break    → exits a LOOP");
        System.out.println("• continue → skips an ITERATION");
        System.out.println("• return   → exits a METHOD");
        System.out.println("\nThis program finished naturally.");
    }
}
