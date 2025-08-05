# Vite ➕ React ➕ Tailwind Starter

**Update:** A `pnpm-lock.yaml` file was added to the root of the project. If possible use `pnpm` over `npm`. You might like it better. See the [pnpm Docs](https://pnpm.io/motivation) if interested. If not, delete this file.

## TLDR

`npm i` to install all devDependencies (includes ESLint and Prettier). `npm start` to start the app. `npm test` to run tests.

**Update:** You may need to do: `npm i --legacy-peer-deps` until all of the modules get synced up for React 17/18. It will all still work though.

## What's Included

* ESLint using AirBnB style guide, integrated with Prettier for formatting.
* VS Code extensions and settings to make it all work seamlessly in VS Code.
* Tailwind CSS for styling.
* [Vitest (in lieu of Jest)](https://vitest.dev/guide/comparisons.html#jest). Also includes the appropriate VS Code extension.
* Automatic import resolutions for aliasing `@` to `./src/`. If this doesn't mean anything to you, don't worry about it (or ask).

### Extensions

In addition to ESLint and Prettier:

* [Better Comments](https://marketplace.visualstudio.com/items?itemName=aaron-bond.better-comments) for...better comments.
* [Tailwind CSS Intellisense](https://marketplace.visualstudio.com/items?itemName=bradlc.vscode-tailwindcss).

### Settings

You should browse and look up the settings. Generally, as soon as you leave the file, it:

* Automatically saves (no need to save manually).
* Automatically formats your code.
* Automatically lints your code.
* Cleans up imports. This includes removing unused imports and sorting them alphabetically. If an import is removed prematurely, just do an undo and they will come right back.
