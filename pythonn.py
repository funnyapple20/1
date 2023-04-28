import requests
import json

while(True):
  headers = {
      "Content-Type": "application/json",
      "Authorization": "Bearer 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"
  }

  data = {
      "prompt": " ",
      "max_tokens": 4000,
      "model": "text-davinci-003"
  }
  prompt1 = input("Enter your prompt")
  data["prompt"] = prompt1

  response = requests.post("https://api.openai.com/v1/completions", headers=headers, data=json.dumps(data))
  response_data = response.json()

  generated_text = response_data["choices"][0]["text"]
  print(generated_text)
