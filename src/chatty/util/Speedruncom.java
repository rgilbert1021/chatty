
package chatty.util;

import chatty.Helper;
import chatty.gui.UrlOpener;
import chatty.gui.components.Channel;
import chatty.util.api.StreamInfo;
import chatty.util.api.TwitchApi;

/**
 *
 * @author tduva
 */
public class Speedruncom {
    
    private final TwitchApi twitchApi;
    
    public Speedruncom(TwitchApi twitchApi) {
        this.twitchApi = twitchApi;
    }
    
    public void openCurrentGame(Channel chan) {
        if (Helper.isRegularChannel(chan.getName())) {
            StreamInfo info = twitchApi.getStreamInfo(chan.getStreamName(), null);
            if (info.isValid() && !info.getGame().isEmpty()) {
                String game = info.getGame();
                UrlOpener.openUrlPrompt(chan, "http://speedrun.com/" + replaceForUrl(game));
                return;
            }
        }
        UrlOpener.openUrlPrompt(chan, "http://speedrun.com");
    }
    
    private static String replaceForUrl(String game) {
        return game.replaceAll(" ", "_").replaceAll(":", "").replaceAll("'", "")
                .replaceAll("&", "and");
    }
    
}
