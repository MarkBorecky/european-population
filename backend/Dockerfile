FROM node:18-alpine
WORKDIR /app
COPY . .
RUN npm ci --quiet

EXPOSE 3001
CMD ["node", "index.js"]
