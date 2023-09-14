"use client";

import { store } from "./store";
import { Provider } from "react-redux";

export function Provider({ children }) {
  return <Provider store={store}>{children}</Provider>;
}
