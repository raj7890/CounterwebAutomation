Xvfb :99 -screen 0 640x480x8 -nolisten tcp &
google-chrome --headless --remote-debugging-port=9222 http://example.com