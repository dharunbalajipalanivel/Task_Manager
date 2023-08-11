
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDate;

/*
<Applet code=CalendarApplet width=450 height=450>
</Applet>
*/

public class CalendarApplet extends Applet {
    private LocalDate currentDate;

    public void init() {
        currentDate = LocalDate.now();
        setSize(400, 300);
        setBackground(Color.WHITE);
    }

    public void paint(Graphics g) {
        int x = 50;
        int y = 50;
        int cellWidth = 50;
        int cellHeight = 30;

        // Draw month and year
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(currentDate.getMonth().toString() + " " + currentDate.getYear(), x, y);

        // Draw days of the week
        y += cellHeight;
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        g.setFont(new Font("Arial", Font.BOLD, 14));
        for (int i = 0; i < daysOfWeek.length; i++) {
            g.drawString(daysOfWeek[i], x + i * cellWidth, y);
        }

        // Draw calendar days
        y += cellHeight;
        int daysInMonth = currentDate.lengthOfMonth();
        int firstDayOfWeek = currentDate.withDayOfMonth(1).getDayOfWeek().getValue();
        int currentDay = 1;
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < firstDayOfWeek - 1) {
                    continue;
                }
                if (currentDay > daysInMonth) {
                    break;
                }
                g.drawString(String.valueOf(currentDay), x + col * cellWidth, y + row * cellHeight);
                currentDay++;
            }
        }
    }
}
