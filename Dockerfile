FROM komljen/jdk-oracle
MAINTAINER Rajukumar <rkmr7890@gmail.com>

RUN \
  apt-get update && \
  apt-get -y install \
          maven && \
  rm -rf /var/lib/apt/lists/*
  
  RUN \
  wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
  echo "deb http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list && \
  apt-get update && \
  apt-get install -y google-chrome-stable && \
  rm -rf /var/lib/apt/lists/*

  
RUN mkdir root/HRMDSP_Automation

WORKDIR /HRMDSP_Automation

RUN pwd

ADD ./ /HRMDSP_Automation


RUN apt-get update && apt-get -y install \
	gtk2-engines-pixbuf \
	libxtst6 \
	xfonts-100dpi \
	xfonts-75dpi \
	xfonts-base \
	xfonts-cyrillic \
	xfonts-scalable \
	xvfb \
	x11vnc

	
# Starting xfvb as a service
RUN mkdir ~/.vnc && touch ~/.vnc/passwd
RUN x11vnc -storepasswd "1989@Kamala" ~/.vnc/passwd
EXPOSE 5920
ENV DISPLAY=:99
CMD ["/usr/bin/x11vnc", "-forever", "-usepw", "-create"]

