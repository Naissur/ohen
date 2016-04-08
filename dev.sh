
tmux new-session -d -s work

## Ohen session

# Org-mode window
# tmux select-window -t work:0
# tmux rename-window 'org'
# tmux send-keys 'cd code/core-graphics/' 'Enter'
# tmux send-keys 'clear' 'Enter'
# tmux send-keys 'vim flow.org'
# tmux send-keys 'Enter'


# Build window
tmux select-window -t work:0
tmux rename-window 'build'
# tmux new-window -n build -t work
tmux send-keys 'lein ring server-headless '
tmux send-keys 'Enter'
tmux split -v
tmux send-keys 'lein repl'
tmux send-keys 'Enter'

# Source window
tmux new-window -n src -t work
tmux send-keys 'cd src/ohen/' 'Enter'
tmux send-keys 'clear' 'Enter'
tmux send-keys 'vim core.clj'
tmux send-keys 'Enter'
                      
# Directory window
tmux new-window -n dir -t work
tmux send-keys 'clear' 'Enter'
                      
# cURL window
tmux new-window -n curl -t work
tmux send-keys 'clear' 'Enter'

tmux attach-session -t work
